package com.application.itunessong.databinding;
import com.application.itunessong.R;
import com.application.itunessong.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemLayoutBindingImpl extends ItemLayoutBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.Iv_ImageOfSong, 3);
        sViewsWithIds.put(R.id.tv_Dummy1, 4);
        sViewsWithIds.put(R.id.tv_Dummy2, 5);
        sViewsWithIds.put(R.id.Button_Play, 6);
        sViewsWithIds.put(R.id.Button_Pause, 7);
    }
    // views
    @NonNull
    private final androidx.cardview.widget.CardView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemLayoutBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }
    private ItemLayoutBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[7]
            , (android.widget.Button) bindings[6]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[5]
            );
        this.TvArtistName.setTag(null);
        this.TvSongName.setTag(null);
        this.mboundView0 = (androidx.cardview.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.songname == variableId) {
            setSongname((com.application.itunessong.responsemodel.Result) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setSongname(@Nullable com.application.itunessong.responsemodel.Result Songname) {
        this.mSongname = Songname;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.songname);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String songnameTrackName = null;
        com.application.itunessong.responsemodel.Result songname = mSongname;
        java.lang.String songnameArtistName = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (songname != null) {
                    // read songname.trackName
                    songnameTrackName = songname.getTrackName();
                    // read songname.artistName
                    songnameArtistName = songname.getArtistName();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.TvArtistName, songnameArtistName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.TvSongName, songnameTrackName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): songname
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}