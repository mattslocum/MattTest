/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import java.util.*;
import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class AAStart extends PAStart
{
    private PAClassDef _aClassDef_;
    private final LinkedList<PAClassDef> _more_ = new LinkedList<PAClassDef>();

    public AAStart()
    {
        // Constructor
    }

    public AAStart(
        @SuppressWarnings("hiding") PAClassDef _aClassDef_,
        @SuppressWarnings("hiding") List<PAClassDef> _more_)
    {
        // Constructor
        setAClassDef(_aClassDef_);

        setMore(_more_);

    }

    @Override
    public Object clone()
    {
        return new AAStart(
            cloneNode(this._aClassDef_),
            cloneList(this._more_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAStart(this);
    }

    public PAClassDef getAClassDef()
    {
        return this._aClassDef_;
    }

    public void setAClassDef(PAClassDef node)
    {
        if(this._aClassDef_ != null)
        {
            this._aClassDef_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._aClassDef_ = node;
    }

    public LinkedList<PAClassDef> getMore()
    {
        return this._more_;
    }

    public void setMore(List<PAClassDef> list)
    {
        this._more_.clear();
        this._more_.addAll(list);
        for(PAClassDef e : list)
        {
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._aClassDef_)
            + toString(this._more_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._aClassDef_ == child)
        {
            this._aClassDef_ = null;
            return;
        }

        if(this._more_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._aClassDef_ == oldChild)
        {
            setAClassDef((PAClassDef) newChild);
            return;
        }

        for(ListIterator<PAClassDef> i = this._more_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PAClassDef) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        throw new RuntimeException("Not a child.");
    }
}